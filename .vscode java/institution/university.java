public class university extends institution {
    private String course_count;
    public university(String name, String city, int launch_year) {
        super(name, city, launch_year);
        this.course_count = course_count;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("No. of courses to be offered: " + course_count);
    }
}