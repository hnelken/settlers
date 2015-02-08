package settlers.catan;

public class DevCard {

	// fields
	
	private Player owner;
	private boolean playable;
	private Type type;
	private String name;
	private String description;

	public enum Type {TROOPER, VP, SANDSTORM, SANDCRAWLER, TWINSUNS}

	// constructors

	public DevCard(Type type) {
		setOwner(null);
		setPlayable(false);
		this.type = type;
		switch (type) {
		case TROOPER:
			setName("Stormtrooper");
			setDescription("Move the robber. Steal 1 resource card from the owner of an adjacent settlement or city.");
			break;
		case SANDSTORM:
			setName("Sandstorm");
			setDescription("When you play this card, all other players must give you all their resource cards of your chosen type.");
			break;
		case SANDCRAWLER:
			setName("Sandcrawler");
			setDescription("Place two new roads as if you had just built them.");
			break;
		case TWINSUNS:
			setName("Twin Suns");
			setDescription("When you play this card, you can select 2 resources of your choice from the bank.");
			break;
		default:
			// no default
		}
	}

	public DevCard(String name){
		setOwner(null);
		setPlayable(false);
		setType(Type.VP);
		setName(name);
		setDescription("1 Victory Point!");
	}

	// methods

	public void play(){
		switch (type) {
			case TROOPER:
				trooperPlay();
				break;
			case SANDCRAWLER:
				break;
			case SANDSTORM:
				break;
			case TWINSUNS:
				break;
			case VP:
				break;
		}
	}

	private void trooperPlay(){

	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isPlayable() {
		return playable;
	}

	public void setPlayable(boolean playable) {
		this.playable = playable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
