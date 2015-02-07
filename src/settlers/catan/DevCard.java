/*<<<<<<< HEAD
package settlers.catan;

public class DevCard {
=======
<<<<<<< HEAD
package settlers.catan;

public class DevCard {
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
<<<<<<< HEAD
>>>>>>> d1d28b02a8629eab975dfe46cc4ce05fb8202ace
>>>>>>> 95c441cc7593179b49dc4171b18b950a0d5ab91a

	// fields
	private Player owner;
	private boolean playable;
	private String name;
	private String description;

	public enum Type {
		TROOPER, VP, SANDSTORM, SANDCRAWLER, BLUEHARVEST
	}

	private Type type;

	// constructors

	public DevCard(Type type) {
		this.owner = null;
		if (type == Type.TROOPER){
			this.setName("Stormtrooper");
<<<<<<< HEAD
=======
			this.setDescription("Move the robber. Steal 1 resource card from the owner of an adjacent settlement or city.");
		}
		else if (type == Type.SANDSTORM){
			this.setName("Sandstorm");
			this.setDescription("When you play this card, you can select two resources of your choice from the bank.");
>>>>>>> 95c441cc7593179b49dc4171b18b950a0d5ab91a
			this.description = "Move the robber. Steal 1 resource card from the owner of an adjacent settlement or city.";
		}
		else if (type == Type.SANDSTORM){
			this.setName("Sandstorm");
			this.description = "When you play this card, you can select two resources of your choice from the bank.";
		}
		else if (type == Type.SANDCRAWLER){
			this.setName("Sandcrawler");
<<<<<<< HEAD
			this.description = "Place two new roads as if you had just built them.";
		}
		else if (type == Type.BLUEHARVEST){
			this.setName("Blue Harvest");
			this.description = "When you play this card, you can select 2 resources of your choice from the bank.";
=======
			this.setDescription("Place two new roads as if you had just built them.");
		}
		else if (type == Type.BLUEHARVEST){
			this.setName("Blue Harvest");
			this.setDescription("When you play this card, you can select 2 resources of your choice from the bank.");
>>>>>>> 95c441cc7593179b49dc4171b18b950a0d5ab91a
		}
		this.setPlayable(false);
	}

<<<<<<< HEAD
=======
	public DevCard(String name){
		this.setName(name);
		this.type = Type.VP;
<<<<<<< HEAD
		this.description = "1 Victory Point!";
=======
		this.setDescription("1 Victory Point!");
>>>>>>> 95c441cc7593179b49dc4171b18b950a0d5ab91a
		this.owner = null;
	}

	public void play(){
		if (type == Type.TROOPER){
			trooperPlay();
		}
		else if (type == Type.SANDSTORM){
		}
		else if (type == Type.SANDCRAWLER){
		}
		else if (type == Type.BLUEHARVEST){
		}
		else if (type == Type.VP){
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
<<<<<<< HEAD
	}

	public void setName(String name) {
		this.name = name;
	}
} */
package settlers.catan;

public class DevCard {

	// fields
	private Player owner;
	private boolean playable;
	private String name;
	private String description;

	public enum Type {
		TROOPER, VP, SANDSTORM, SANDCRAWLER, BLUEHARVEST
	}

	private Type type;

	// constructors

	public DevCard(Type type) {
		this.owner = null;
		if (type == Type.TROOPER){
			this.setName("Stormtrooper");
			this.setDescription("Move the robber. Steal 1 resource card from the owner of an adjacent settlement or city.");
		}
		else if (type == Type.SANDSTORM){
			this.setName("Sandstorm");
			this.setDescription("When you play this card, you can select two resources of your choice from the bank.");
			this.description = "Move the robber. Steal 1 resource card from the owner of an adjacent settlement or city.";
		}
		else if (type == Type.SANDSTORM){
			this.setName("Sandstorm");
			this.description = "When you play this card, you can select two resources of your choice from the bank.";
		}
		else if (type == Type.SANDCRAWLER){
			this.setName("Sandcrawler");
			this.setDescription("Place two new roads as if you had just built them.");
		}
		else if (type == Type.BLUEHARVEST){
			this.setName("Blue Harvest");
			this.setDescription("When you play this card, you can select 2 resources of your choice from the bank.");
		}
		this.setPlayable(false);
	}

=======
=======
 
 // fields
 private Player owner;
 private boolean playable;
 private String name;
 private String description;
 
 public enum Type {
  TROOPER, VP, SANDSTORM, SANDCRAWLER, BLUEHARVEST
 }
 
 private Type type;
 
 // constructors
 
 public DevCard(Type type) {
  this.owner = null;
  if (type == Type.TROOPER){
   this.setName("Stormtrooper");
   this.description = "Move the robber. Steal 1 resource card from the owner of an adjacent settlement or city.";
  }
  else if (type == Type.SANDSTORM){
   this.setName("Sandstorm");
   this.description = "When you play this card, you can select two resources of your choice from the bank.";
  }
  else if (type == Type.SANDCRAWLER){
   this.setName("Sandcrawler");
   this.description = "Place two new roads as if you had just built them.";
  }
  else if (type == Type.BLUEHARVEST){
   this.setName("Blue Harvest");
   this.description = "When you play this card, you can select 2 resources of your choice from the bank.";
  }
  this.setPlayable(false);
 }
 
 public DevCard(String name){
  this.setName(name);
  this.type = Type.VP;
  this.description = "1 Victory Point!";
  this.owner = null;
 }
 
 public void play(){
  if (type == Type.TROOPER){
	  trooperPlay();
  }
  else if (type == Type.SANDSTORM){
  }
  else if (type == Type.SANDCRAWLER){
  }
  else if (type == Type.BLUEHARVEST){
  }
  else if (type == Type.VP){
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
}
=======
	package settlers.catan;
	
	public class DevCard {
	 
	 // fields
	 private Player owner;
	 private boolean playable;
	 private String name;
	 private String description;
	 
	 public enum Type {
	  TROOPER, VP, SANDSTORM, SANDCRAWLER, BLUEHARVEST
	 }
	 
	 private Type type;
	 
	 // constructors
	 
	 public DevCard(Type type) {
	  this.owner = null;
	  if (type == Type.TROOPER){
	   this.setName("Stormtrooper");
	   this.setDescription("Move the robber. Steal 1 resource card from the owner of an adjacent settlement or city.");
	  }
	  else if (type == Type.SANDSTORM){
	   this.setName("Sandstorm");
	   this.setDescription("When you play this card, you can select two resources of your choice from the bank.");
	   this.description = "Move the robber. Steal 1 resource card from the owner of an adjacent settlement or city.";
	  }
	  else if (type == Type.SANDSTORM){
	   this.setName("Sandstorm");
	   this.description = "When you play this card, you can select two resources of your choice from the bank.";
	  }
	  else if (type == Type.SANDCRAWLER){
	   this.setName("Sandcrawler");
	   this.setDescription("Place two new roads as if you had just built them.");
	  }
	  else if (type == Type.BLUEHARVEST){
	   this.setName("Blue Harvest");
	   this.setDescription("When you play this card, you can select 2 resources of your choice from the bank.");
	  }
	  this.setPlayable(false);
	 }
	
>>>>>>> 95c441cc7593179b49dc4171b18b950a0d5ab91a
	public DevCard(String name){
		this.setName(name);
		this.type = Type.VP;
		this.setDescription("1 Victory Point!");
		this.owner = null;
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

	public String getDescription() {
		return description;
>>>>>>> dba453eea640a12c1664ee5411c9435d028b617f
	}

	public void setName(String name) {
		this.name = name;
	}
<<<<<<< HEAD

	public void setDescription(String description) {
		this.description = description;
	}

}
=======
<<<<<<< HEAD

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
=======
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	}
>>>>>>> 60fda28673a3592eea910d0055dbbddc17c58d85
>>>>>>> dba453eea640a12c1664ee5411c9435d028b617f
>>>>>>> 95c441cc7593179b49dc4171b18b950a0d5ab91a
