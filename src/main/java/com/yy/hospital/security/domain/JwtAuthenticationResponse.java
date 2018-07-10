package com.yy.hospital.security.domain;

import java.io.Serializable;

/**
 * 响应令牌类
 */

public class JwtAuthenticationResponse implements Serializable {
  private static final long serialVersionUID = 4784951536404964122L;
  private final String token;   //要发送回客户端的令牌

  public JwtAuthenticationResponse(String token) {
    this.token = token;
  }

  public String getToken() {
    return this.token;
  }
}
