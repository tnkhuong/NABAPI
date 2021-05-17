package apis.endpoints;

public enum EnvironmentType {

    Stage ("src/main/resources/environments/stage.properties"),
    Mock ("src/main/resources/environments/mock.properties");

    private String resource;

    EnvironmentType(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }
}
