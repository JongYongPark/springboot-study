package ryanpark.spring.web.service.sdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

//sdo : service domain object
//cdo : Creative Domain Object 생성될때 필요한 object
//	실제 필요한 것은 name과 intro만 필요하다.

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TravelClubCdo implements Serializable {
    //
    private String name;
    private String intro;
}
