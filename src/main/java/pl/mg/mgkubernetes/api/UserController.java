package pl.mg.mgkubernetes.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

  @GetMapping
  public ResponseEntity<String> apiCheck() {
    return ResponseEntity.ok("User returned v1");
  }
}
