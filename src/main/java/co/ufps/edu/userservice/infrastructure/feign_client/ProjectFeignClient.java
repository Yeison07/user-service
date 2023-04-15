package co.ufps.edu.userservice.infrastructure.feign_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "project-service", path = "/api/v1/projects", url = "localhost:8080")
public interface ProjectFeignClient {

    @PostMapping("/getAllProjectsById")
    List<Object> getProjectByUserId(@RequestBody List<Long> projectsId);
}
