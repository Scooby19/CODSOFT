public class Course {
    String code,title,description,schedule;
    int capacity;
    public Course(String code,String title,String description,String schedule,
    int capacity){
    this.code = code;
    this.title = title;
    this.description = description;
    this.schedule = schedule;
    this.capacity = capacity;
    }

    public void showDetails(){
        System.out.println("COURSE : "+title+"("+code+")");
        System.out.println("DESCRIPTION : "+description);
        System.out.println("SCHEDULE : "+schedule);
        System.out.println("CAPACITY : "+capacity);

    }
}
