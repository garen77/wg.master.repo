package com.wg.services.api;

import java.util.List;

import com.wg.model.BaseModel;

public interface ILoaderServices {

	public List<? extends BaseModel> loadAllCharacter();
}
