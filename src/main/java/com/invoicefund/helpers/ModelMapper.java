package com.invoicefund.helpers;

import com.invoicefund.models.User;
import com.invoicefund.models.dto.UserDtoOut;
import com.invoicefund.services.interfaces.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    public ModelMapper() {
    }

    public UserDtoOut fromUserToUserDtoOut(User user) {
        UserDtoOut dtoOut = new UserDtoOut();

        dtoOut.setFirstName(user.getFirstName());
        dtoOut.setUsername(user.getUsername());

        return dtoOut;
    }
}
