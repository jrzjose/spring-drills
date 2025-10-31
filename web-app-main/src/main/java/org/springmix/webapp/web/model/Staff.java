package org.springmix.webapp.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
  private UUID id;
  private String firstName;
  private String lastName;
  private String position;
}
