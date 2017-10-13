package ua.service;

import java.util.List;

import ua.domain.request.PhotoRequest;
import ua.domain.view.PhotoDto;
import ua.entity.Photo;

public interface PhotoService extends CrudService<Photo, Integer>{
	
	List<PhotoDto> findAllPhoto();
	
	void save(PhotoRequest photoRequest);
}
