package edu.springorm.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final Repositary repo;

    public StudentServiceImpl(Repositary repo){
        this.repo = repo;
    }

    @Override
    public List<Student> getAll(){
        return repo.findAll();
    }

    @Override
    public Student getById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public Student create(Student student){
        return repo.save(student);
    }

    @Override
    public Student update(Long id, Student student){

        Student existing = repo.findById(id).orElse(null);

        if(existing != null){
            existing.setName(student.getName());
            existing.setEmail(student.getEmail());
            existing.setDepartment(student.getDepartment());
            return repo.save(existing);
        }

        return null;
    }

    @Override
    public void delete(Long id){
        repo.deleteById(id);
    }
}