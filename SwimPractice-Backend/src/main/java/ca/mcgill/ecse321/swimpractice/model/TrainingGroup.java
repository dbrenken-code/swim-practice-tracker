/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 21 "model.ump"
// line 61 "model.ump"
public class TrainingGroup
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TrainingGroup Attributes
  private String name;

  //TrainingGroup Associations
  private List<Group> groups;
  private List<Practice> practices;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TrainingGroup(String aName)
  {
    name = aName;
    groups = new ArrayList<Group>();
    practices = new ArrayList<Practice>();
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
  /* Code from template association_GetMany */
  public Practice getPractice(int index)
  {
    Practice aPractice = practices.get(index);
    return aPractice;
  }

  public List<Practice> getPractices()
  {
    List<Practice> newPractices = Collections.unmodifiableList(practices);
    return newPractices;
  }

  public int numberOfPractices()
  {
    int number = practices.size();
    return number;
  }

  public boolean hasPractices()
  {
    boolean has = practices.size() > 0;
    return has;
  }

  public int indexOfPractice(Practice aPractice)
  {
    int index = practices.indexOf(aPractice);
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
    if (aGroup.indexOfTrainingGroup(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aGroup.addTrainingGroup(this);
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
    if (aGroup.indexOfTrainingGroup(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aGroup.removeTrainingGroup(this);
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPractices()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPractice(Practice aPractice)
  {
    boolean wasAdded = false;
    if (practices.contains(aPractice)) { return false; }
    practices.add(aPractice);
    if (aPractice.indexOfTrainingGroup(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPractice.addTrainingGroup(this);
      if (!wasAdded)
      {
        practices.remove(aPractice);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePractice(Practice aPractice)
  {
    boolean wasRemoved = false;
    if (!practices.contains(aPractice))
    {
      return wasRemoved;
    }

    int oldIndex = practices.indexOf(aPractice);
    practices.remove(oldIndex);
    if (aPractice.indexOfTrainingGroup(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPractice.removeTrainingGroup(this);
      if (!wasRemoved)
      {
        practices.add(oldIndex,aPractice);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPracticeAt(Practice aPractice, int index)
  {  
    boolean wasAdded = false;
    if(addPractice(aPractice))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPractices()) { index = numberOfPractices() - 1; }
      practices.remove(aPractice);
      practices.add(index, aPractice);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePracticeAt(Practice aPractice, int index)
  {
    boolean wasAdded = false;
    if(practices.contains(aPractice))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPractices()) { index = numberOfPractices() - 1; }
      practices.remove(aPractice);
      practices.add(index, aPractice);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPracticeAt(aPractice, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Group> copyOfGroups = new ArrayList<Group>(groups);
    groups.clear();
    for(Group aGroup : copyOfGroups)
    {
      aGroup.removeTrainingGroup(this);
    }
    ArrayList<Practice> copyOfPractices = new ArrayList<Practice>(practices);
    practices.clear();
    for(Practice aPractice : copyOfPractices)
    {
      aPractice.removeTrainingGroup(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]";
  }
}
