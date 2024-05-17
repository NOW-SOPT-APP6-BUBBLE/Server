package com.sopt.mobile.exception;

import com.sopt.mobile.common.dto.ErrorMessage;
import lombok.Getter;

@Getter
public class NotFoundException extends BusinessException {

  public NotFoundException(ErrorMessage errorMessage) {
    super(errorMessage);
  }

}


