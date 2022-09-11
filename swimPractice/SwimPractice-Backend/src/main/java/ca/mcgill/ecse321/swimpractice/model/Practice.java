/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 26 "model.ump"
// line 66 "model.ump"
public class Practice
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Practice Attributes
  private String id;

  //Practice Associations
  private List<TrainingGroup> trainingGroups;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Practice(String aId)
  {
    id = aId;
    trainingGroups = new ArrayList<TrainingGroup>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
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
    if (aTrainingGroup.indexOfPractice(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTrainingGroup.addPractice(this);
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
    if (aTrainingGroup.indexOfPractice(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTrainingGroup.removePractice(this);
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
    ArrayList<TrainingGroup> copyOfTrainingGroups = new ArrayList<TrainingGroup>(trainingGroups);
    trainingGroups.clear();
    for(TrainingGroup aTrainingGroup : copyOfTrainingGroups)
    {
      aTrainingGroup.removePractice(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "]";
  }
}