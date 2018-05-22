package pl.coderslab.crm.service;

import org.springframework.stereotype.Service;
import pl.coderslab.crm.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;

    }
}
