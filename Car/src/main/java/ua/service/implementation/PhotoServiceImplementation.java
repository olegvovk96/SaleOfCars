package ua.service.implementation;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static ua.mapper.PhotoMapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.domain.request.PhotoRequest;
import ua.domain.view.PhotoDto;
import ua.entity.Photo;
import ua.repository.PhotoRepository;
import ua.service.PhotoService;

@Service
public class PhotoServiceImplementation implements PhotoService{

	private final PhotoRepository repository;

	@Autowired
	public PhotoServiceImplementation(PhotoRepository repository) {
		this.repository = repository;
	}
	
	@Value("${file.path}")
	private String path;

	@Override
	public Photo findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Photo> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Photo entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}
	
	@Override
	public List<PhotoDto> findAllPhoto() {
		return toPhotoMapper(repository.findAllPhoto());
	}

	@Override
	public void save(PhotoRequest photoRequest) {
		Photo photo = toPhoto(photoRequest);
		MultipartFile file = photoRequest.getFile();
		if(file != null && !file.isEmpty()){
			System.out.println("dsdds");
			String extention = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String fileName = UUID.randomUUID().toString()+extention;
			try {
				file.transferTo(new File(path + fileName));
				photo.setPhotourl(fileName);
				photo.setVersion(1);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(photo.getPhotourl());
		repository.save(photo);
	}	
}
