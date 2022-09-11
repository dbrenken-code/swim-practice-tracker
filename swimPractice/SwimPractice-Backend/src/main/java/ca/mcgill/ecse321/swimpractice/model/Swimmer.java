/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 16 "model.ump"
// line 56 "model.ump"
public class Swimmer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Swimmer Attributes
  private String name;

  //Swimmer Associations
  private List<Group> groups;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Swimmer(String aName)
  {
    name = aName;
    groups = new ArrayList<Group>();
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
  public Group getGroup(int index)
  {
    Group aGroup = groups.get(index);
    return aGroup;
  }

  public List<Group> getGroups()
  {
    List<Group> newGroups = Collections.unmodifiableList(groups);
    return newGroups;
  }

  public int numberOfGroups()
  {
    int number = groups.size();
    return number;
  }

  public boolean hasGroups()
  {
    boolean has = groups.size() > 0;
    return has;
  }

  public int indexOfGroup(Group aGroup)
  {
    int index = groups.indexOf(aGroup);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGroups()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addGroup(Group aGroup)
  {
    boolean wasAdded = false;
    if (groups.contains(aGroup)) { return false; }
    groups.add(aGroup);
    if (aGroup.indexOfSwimmer(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aGroup.addSwimmer(this);
      if (!wasAdded)
      {
        groups.remove(aGroup);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeGroup(Group aGroup)
  {
    boolean wasRemoved = false;
    if (!groups.contains(aGroup))
    {
      return wasRemoved;
    }

    int oldIndex = groups.indexOf(aGroup);
    groups.remove(oldIndex);
    if (aGroup.indexOfSwimmer(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aGroup.removeSwimmer(this);
      if (!wasRemoved)
      {
        groups.add(oldIndex,aGroup);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addGroupAt(Group aGroup, int index)
  {  
    boolean wasAdded = false;
    if(addGroup(aGroup))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGroups()) { index = numberOfGroups() - 1; }
      groups.remove(aGroup);
      groups.add(index, aGroup);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGroupAt(Group aGroup, int index)
  {
    boolean wasAdded = false;
    if(groups.contains(aGroup))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGroups()) { index = numberOfGroups() - 1; }
      groups.remove(aGroup);
      groups.add(index, aGroup);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGroupAt(aGroup, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Group> copyOfGroups = new ArrayList<Group>(groups);
    groups.clear();
    for(Group aGroup : copyOfGroups)
    {
      aGroup.removeSwimmer(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]";
  }
}

