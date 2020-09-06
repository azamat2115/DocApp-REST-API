package uz.azamat.demo.service;

import org.springframework.stereotype.Service;
import uz.azamat.demo.model.Application;
import uz.azamat.demo.model.User;
import uz.azamat.demo.repository.ApplicationRepository;

import java.util.List;

@Service
public class ApplicationService {
    ApplicationRepository applicationRepository;
    UserService userService;

    public ApplicationService(ApplicationRepository applicationRepository, UserService userService) {
        this.applicationRepository = applicationRepository;
        this.userService = userService;
    }

    public void saveApplication(Application application) {
        User user = userService.findByID(1);
        application.setUser(user);
        applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application updateApplication(Application application, int id) {
        Application updatedApplication = applicationRepository.findById(id);
        updatedApplication.setId(id);
        updatedApplication.setHeading(application.getHeading());
        updatedApplication.setText(application.getText());
        updatedApplication.setDate(application.getDate());

        return applicationRepository.save(updatedApplication);

    }
    public int deleteById(int id){
        return applicationRepository.deleteById(id);
    }
}
