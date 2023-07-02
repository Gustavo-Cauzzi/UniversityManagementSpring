package com.gestao.security.jwt;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class TokenProps implements Serializable {
	
	private static final long serialVersionUID = -8566355560312308067L;

    private final Long timeTokenInSeconds = 999999999999L;

    private final String secret = "8MhsKL5/hAcT7KRnHgU460wbUeCWs/LvCbq6sK7BDi1b1gUbetPS2nw+akr/0eZSvgG/8uMntABbH659j13yEhkcDCsL/nmKFcL1et4DsipwAEIp0zNA4+LpokVpXXXLNUjKznchhtX9mMnOpr2AHWbE5j2vGUJGcfTQlkJLZrvsBSvQVtEm2w6IEpV/RPeCx3qKon2jl+d21Dxp/gXWUc/4yG6qdh/E3acKmUA1elcTb5KZlM5is3Ka9ZxtXXbgXKL9yoh8FHVYGkm6uneaaVBGEV+gG64rZgqqHTLYC9EOAyr/wHgx8+uYkuvZ9SfP8ATFY6bmpZxO5rahXxhRujTDWiNRZH72KSbrz8v+H9NZDDdBReX6g1laniSPouq5GHza5FifmNpMwpBQQr5nP+iazbUtvtEHtPABD6wuL7tQuYcftePXxtxmsEYF0oWINhguW1sbe9ruRpzjPIp8nS6etFViu+A6jl84ayy9soNTY4VVNh2wuvG8k+s8Bt2wH5UxLXXb9yxP5uowIid4Zz7doVyYa+El1yASJm0hoszWykEebURmipBrn+s/ea8uOUI7tM35pO6pyq+b135pw4SDPG+BnFGiDohVCoAfuCUffgpSOZIHpsXkJr9h9XJMKTu+FrN67T2TW/3JtJ5YhK3D3yezA+CLqM=";

    public Long getTimeTokenInSeconds() {
        return timeTokenInSeconds;
    }


    public String getSecret() {
        return secret;
    }

}
