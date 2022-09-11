/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 7 "model.ump"
// line 47 "model.ump"
public class Group
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Group Attributes
  private String name;

  //Group Associations
  private List<Organization> organizations;
  private List<Swimmer> swimmers;
  private List<Zone> zones;
  private List<TrainingGroup> trainingGroups;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Group(String aName)
  {
    name = aName;
    organizations = new ArrayList<Organization>();
    swimmers = new ArrayList<Swimmer>();
    zones = new ArrayList<Zone>();
    trainingGroups = new ArrayList<TrainingGroup>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetMany */
  public Organization getOrganization(int index)
  {
    Organization aOrganization = organizations.get(index);
    return aOrganization;
  }

  public List<Organization> getOrganizations()
  {
    List<Organization> newOrganizations = Collections.unmodifiableList(organizations);
    return newOrganizations;
  }

  public int numberOfOrganizations()
  {
    int number = organizations.size();
    return number;
  }

  public boolean hasOrganizations()
  {
    boolean has = organizations.size() > 0;
    return has;
  }

  public int indexOfOrganization(Organization aOrganization)
  {
    int index = organizations.indexOf(aOrganization);
    return index;
  }
  /* Code from template association_GetMany */
  public Swimmer getSwimmer(int index)
  {
    Swimmer aSwimmer = swimmers.get(index);
    return aSwimmer;
  }

  public List<Swimmer> getSwimmers()
  {
    List<Swimmer> newSwimmers = Collections.unmodifiableList(swimmers);
    return newSwimmers;
  }

  public int numberOfSwimmers()
  {
    int number = swimmers.size();
    return number;
  }

  public boolean hasSwimmers()
  {
    boolean has = swimmers.size() > 0;
    return has;
  }

  public int indexOfSwimmer(Swimmer aSwimmer)
  {
    int index = swimmers.indexOf(aSwimmer);
    return index;
  }
  /* Code from template association_GetMany */
  public Zone getZone(int index)
  {
    Zone aZone = zones.get(index);
    return aZone;
  }

  public List<Zone> getZones()
  {
    List<Zone> newZones = Collections.unmodifiableList(zones);
    return newZones;
  }

  public int numberOfZones()
  {
    int number = zones.size();
    return number;
  }

  public boolean hasZones()
  {
    boolean has = zones.size() > 0;
    return has;
  }

  public int indexOfZone(Zone aZone)
  {
    int index = zones.indexOf(aZone);
    return index;
  }
  /* Code from template association_GetMany */
  public TrainingGroup getTrainingGroup(int index)
  {
    TrainingGroup aTrainingGroup = trainingGroups.get(index);
    return aTrainingGroup;
  }

  public List<TrainingGroup> getTrainingGroups()
  {
    List<TrainingGroup> newTrainingGroups = Collections.unmodifiableList(trainingGroups);
    return newTrainingGroups;
  }

  public int numberOfTrainingGroups()
  {
    int number = trainingGroups.size();
    return number;
  }

  public boolean hasTrainingGroups()
  {
    boolean has = trainingGroups.size() > 0;
    return has;
  }

  public int indexOfTrainingGroup(TrainingGroup aTrainingGroup)
  {
    int index = trainingGroups.indexOf(aTrainingGroup);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrganizations()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addOrganization(Organization aOrganization)
  {
    boolean wasAdded = false;
    if (organizations.contains(aOrganization)) { return false; }
    organizations.add(aOrganization);
    if (aOrganization.indexOfGroup(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aOrganization.addGroup(this);
      if (!wasAdded)
      {
        organizations.remove(aOrganization);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeOrganization(Organization aOrganization)
  {
    boolean wasRemoved = false;
    if (!organizations.contains(aOrganization))
    {
      return wasRemoved;
    }

    int oldIndex = organizations.indexOf(aOrganization);
    organizations.remove(oldIndex);
    if (aOrganization.indexOfGroup(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aOrganization.removeGroup(this);
      if (!wasRemoved)
      {
        organizations.add(oldIndex,aOrganization);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOrganizationAt(Organization aOrganization, int index)
  {  
    boolean wasAdded = false;
    if(addOrganization(aOrganization))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrganizations()) { index = numberOfOrganizations() - 1; }
      organizations.remove(aOrganization);
      organizations.add(index, aOrganization);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrganizationAt(Organization aOrganization, int index)
  {
    boolean wasAdded = false;
    if(organizations.contains(aOrganization))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrganizations()) { index = numberOfOrganizations() - 1; }
      organizations.remove(aOrganization);
      organizations.add(index, aOrganization);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrganizationAt(aOrganization, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSwimmers()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addSwimmer(Swimmer aSwimmer)
  {
    boolean wasAdded = false;
    if (swimmers.contains(aSwimmer)) { return false; }
    swimmers.add(aSwimmer);
    if (aSwimmer.indexOfGroup(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSwimmer.addGroup(this);
      if (!wasAdded)
      {
        swimmers.remove(aSwimmer);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeSwimmer(Swimmer aSwimmer)
  {
    boolean wasRemoved = false;
    if (!swimmers.contains(aSwimmer))
    {
      return wasRemoved;
    }

    int oldIndex = swimmers.indexOf(aSwimmer);
    swimmers.remove(oldIndex);
    if (aSwimmer.indexOfGroup(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSwimmer.removeGroup(this);
      if (!wasRemoved)
      {
        swimmers.add(oldIndex,aSwimmer);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSwimmerAt(Swimmer aSwimmer, int index)
  {  
    boolean wasAdded = false;
    if(addSwimmer(aSwimmer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSwimmers()) { index = numberOfSwimmers() - 1; }
      swimmers.remove(aSwimmer);
      swimmers.add(index, aSwimmer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSwimmerAt(Swimmer aSwimmer, int index)
  {
    boolean wasAdded = false;
    if(swimmers.contains(aSwimmer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSwimmers()) { index = numberOfSwimmers() - 1; }
      swimmers.remove(aSwimmer);
      swimmers.add(index, aSwimmer);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSwimmerAt(aSwimmer, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfZones()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addZone(Zone aZone)
  {
    boolean wasAdded = false;
    if (zones.contains(aZone)) { return false; }
    zones.add(aZone);
    if (aZone.indexOfGroup(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aZone.addGroup(this);
      if (!wasAdded)
      {
        zones.remove(aZone);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeZone(Zone aZone)
  {
    boolean wasRemoved = false;
    if (!zones.contains(aZone))
    {
      return wasRemoved;
    }

    int oldIndex = zones.indexOf(aZone);
    zones.remove(oldIndex);
    if (aZone.indexOfGroup(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aZone.removeGroup(this);
      if (!wasRemoved)
      {
        zones.add(oldIndex,aZone);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addZoneAt(Zone aZone, int index)
  {  
    boolean wasAdded = false;
    if(addZone(aZone))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfZones()) { index = numberOfZones() - 1; }
      zones.remove(aZone);
      zones.add(index, aZone);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveZoneAt(Zone aZone, int index)
  {
    boolean wasAdded = false;
    if(zones.contains(aZone))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfZones()) { index = numberOfZones() - 1; }
      zones.remove(aZone);
      zones.add(index, aZone);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addZoneAt(aZone, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTrainingGroups()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addTrainingGroup(TrainingGroup aTrainingGroup)
  {
    boolean wasAdded = false;
    if (trainingGroups.contains(aTrainingGroup)) { return false; }
    trainingGroups.add(aTrainingGroup);
    if (aTrainingGroup.indexOfGroup(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTrainingGroup.addGroup(this);
      if (!wasAdded)
      {
        trainingGroups.remove(aTrainingGroup);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeTrainingGroup(TrainingGroup aTrainingGroup)
  {
    boolean wasRemoved = false;
    if (!trainingGroups.contains(aTrainingGroup))
    {
      return wasRemoved;
    }

    int oldIndex = trainingGroups.indexOf(aTrainingGroup);
    trainingGroups.remove(oldIndex);
    if (aTrainingGroup.indexOfGroup(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTrainingGroup.removeGroup(this);
      if (!wasRemoved)
      {
        trainingGroups.add(oldIndex,aTrainingGroup);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTrainingGroupAt(TrainingGroup aTrainingGroup, int index)
  {  
    boolean wasAdded = false;
    if(addTrainingGroup(aTrainingGroup))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTrainingGroups()) { index = numberOfTrainingGroups() - 1; }
      trainingGroups.remove(aTrainingGroup);
      trainingGroups.add(index, aTrainingGroup);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTrainingGroupAt(TrainingGroup aTrainingGroup, int index)
  {
    boolean wasAdded = false;
    if(trainingGroups.contains(aTrainingGroup))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTrainingGroups()) { index = numberOfTrainingGroups() - 1; }
      trainingGroups.remove(aTrainingGroup);
      trainingGroups.add(index, aTrainingGroup);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTrainingGroupAt(aTrainingGroup, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Organization> copyOfOrganizations = new ArrayList<Organization>(organizations);
    organizations.clear();
    for(Organization aOrganization : copyOfOrganizations)
    {
      aOrganization.removeGroup(this);
    }
    ArrayList<Swimmer> copyOfSwimmers = new ArrayList<Swimmer>(swimmers);
    swimmers.clear();
    for(Swimmer aSwimmer : copyOfSwimmers)
    {
      aSwimmer.removeGroup(this);
    }
    ArrayList<Zone> copyOfZones = new ArrayList<Zone>(zones);
    zones.clear();
    for(Zone aZone : copyOfZones)
    {
      aZone.removeGroup(this);
    }
    ArrayList<TrainingGroup> copyOfTrainingGroups = new ArrayList<TrainingGroup>(trainingGroups);
    trainingGroups.clear();
    for(TrainingGroup aTrainingGroup : copyOfTrainingGroups)
    {
      aTrainingGroup.removeGroup(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]";
  }
}

