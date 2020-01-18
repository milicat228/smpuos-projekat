package rs.uns.ftn.acs.exceptions;

public class ResourceNotFoundException extends Exception{
	private static final long serialVersionUID = 5198244129753372024L;
	private String resourceId;

	public ResourceNotFoundException(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getMessage() {
		return "Resource with id " + this.resourceId + " not found.";
	}
}
