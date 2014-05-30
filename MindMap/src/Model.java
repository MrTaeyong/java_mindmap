
public class Model {
	private NodeDTO root;
	
	public Model(){
		
	}

	public NodeDTO getRoot() {
		return root;
	}

	public void setRoot(NodeDTO root) {
		this.root = root;
	}
	
	public void addNode(NodeDTO parent){
		parent.setChild(new NodeDTO(parent));
	}
}
