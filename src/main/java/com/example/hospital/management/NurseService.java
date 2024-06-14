package com.example.hospital.management;

import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class NurseService {
    NurseRepository nurseRepository =new NurseRepository();

    public String addNurse(Nurse nurse){
  String ans=nurseRepository.addNurse( nurse);
  return ans;
    }
    public List<Nurse> getList(int age){
List<Nurse> nurses=nurseRepository.getAllNurses();
List <Nurse> finalList=new ArrayList<>();
    for(Nurse nurse: nurses){
        if(nurse.getAge()>age){
            finalList.add(nurse);
        }
    }
    return finalList;
    }
    public List<Nurse> getNursesWithQualification(String qualification){
List<Nurse> nurseList=nurseRepository.getAllNurses();
List<Nurse> nurses = new ArrayList<>();
for(Nurse nurse : nurseList){
    if(nurse.getQualification().equals(qualification)){
        nurses.add(nurse);
    }

}
return nurses;
    }
}
