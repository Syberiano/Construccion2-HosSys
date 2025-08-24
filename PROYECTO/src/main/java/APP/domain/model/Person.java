package APP.domain.model;

public class Person {
    private Long id;
    private String document;
    private String name;

 
    public Person(Long id, String document, String name) {
        this.id = id;
        this.document = document;
        this.name = name;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
