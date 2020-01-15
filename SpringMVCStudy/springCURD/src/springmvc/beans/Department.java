package springmvc.beans;

public class Department {
    private Integer id;
    private String departmentName;

    public Department() {
        //TODO Auto-generated constructor stub
    }


    public Department(Integer i, String s) {
        this.id = i;
        this.departmentName = s;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
