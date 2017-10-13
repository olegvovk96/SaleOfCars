package ua.mapper;

import java.util.List;
import java.util.stream.Collectors;

import ua.domain.request.PhotoRequest;
import ua.domain.view.PhotoDto;
import ua.entity.Photo;

public interface PhotoMapper {

	public static PhotoDto toPhotoMapper(Photo photo){
		Integer id = photo.getId();
		String photourl = photo.getPhotourl();
		Integer version = photo.getVersion();
		String car = photo.getCar().getModel().getName();
		return new PhotoDto(id, photourl, version, car);
	}
	
	public static List<PhotoDto> toPhotoMapper(List<Photo> photos){
		return photos.stream() 
			   .map(PhotoMapper::toPhotoMapper)
			   .collect(Collectors.toList());
	}
	
	public static Photo toPhoto(PhotoRequest photoRequest){
		Photo photo = new Photo();
		photo.setCar(photoRequest.getCar());
		photo.setId(photoRequest.getId());
		return photo;
	}
}
