package co.edu.polijic.taller.controller;

//import co.edu.polijic.taller.helpers.ErrorMessage;
import co.com.helpers.ErrorMessage;
//import co.edu.polijic.taller.helpers.Response;
import co.com.helpers.Response;
import co.edu.polijic.taller.helpers.ResponseBuild;
import co.edu.polijic.taller.model.constants.StatusTask;
import co.edu.polijic.taller.model.dto.ProjectTaskDto;
import co.edu.polijic.taller.model.entity.ProjectTask;
import co.edu.polijic.taller.service.ProjectTaskService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class ProjectTaskController {

    private final ProjectTaskService projectTaskService;
    private final ResponseBuild builder;

    @PostMapping
    public Response save(@Valid @RequestBody ProjectTaskDto projectTaskDto, BindingResult result) {
        if (result.hasErrors()) {
            return builder.failed(formatMessage(result));
        }
        return builder.created(projectTaskService.save(projectTaskDto));
    }


    @GetMapping("/task/project/{projectIdentifier}")
    public Response findAllTaskByProjectIdentifier(@PathVariable("projectIdentifier") String projectIdentifier) {
        List<ProjectTask> projectTasks = projectTaskService.findByProjectIdentifier(projectIdentifier);
        if (projectTasks.isEmpty()) {
            return builder.notFound();
        }
        return builder.success(projectTasks);
    }

    @GetMapping("/task/project/hours/{projectIdentifier}")
    public Response numberOfHoursTasks(@PathVariable("projectIdentifier") String projectIdentifier) {
        return builder.success(projectTaskService.totalHoursTasks(projectIdentifier));
    }

    @GetMapping("/task/project/hours/{projectIdentifier}/{status}")
    public Response numberOfHoursTasksByStatus(@PathVariable("projectIdentifier") String projectIdentifier,
                                               @PathVariable("status") StatusTask statusTask) {
        return builder.success(projectTaskService.totalHoursTasksByStatus(projectIdentifier, statusTask));
    }

    @PatchMapping("/task/{idtask}/{projectIdentifier}")
    public Response deleteTask(
            @PathVariable("idtask") Long idTask, @PathVariable("projectIdentifier") String projectIdentifier) {
        return builder.success(projectTaskService.deleteTask(idTask,projectIdentifier));
    }

    private String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .error(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return json;
    }
}
