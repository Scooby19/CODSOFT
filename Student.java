import java.util.ArrayList;
public class Student {
    String name;
    int id;
    ArrayList<Course> registeredCourses;
    public Student(String name,int id){
        this.name = name;
        this.id = id;
        registeredCourses = new ArrayList<>();
    }

    public void registerCourses(Course obj){
        if(registeredCourses.contains(obj)){
            System.out.println("Already registered in "+obj.code);
        }
        else if(obj.capacity<=0){
            System.out.println("Course is full");
        }
        else{
            registeredCourses.add(obj);
            obj.capacity--;
            System.out.println("Registered in "+obj.code);
        }
    }

    public void dropCourse(Course obj){
        if(registeredCourses.remove(obj)){
            System.out.println("Dropped course: "+obj.code);
        }
        else{
            System.out.println("Not registered in this course.");
        }
    }

    public void viewRegisteredCourse(){
        if(registeredCourses.isEmpty()){
            System.out.println("No courses registered.");
        }
        else{
            System.out.println("Your Courses : ");
            for(Course c : registeredCourses){
                System.out.println("=>"+c.title+"("+c.code+")");
            }
        }
    }
}

