package org.omg.dds.core.policy;

public interface PolicyFactory extends org.omg.dds.core.DDSObject {

    /**
     * @return the durability
     */
    public Durability Durability();

    /**
     * @return the deadline
     */
    public Deadline Deadline();

    /**
     * @return the latencyBudget
     */
    public LatencyBudget LatencyBudget();

    /**
     * @return the liveliness
     */
    public Liveliness Liveliness();

    /**
     * @return the destinationOrder
     */
    public DestinationOrder DestinationOrder();

    /**
     * @return the history
     */
    public History History();

    /**
     * @return the resourceLimits
     */
    public ResourceLimits ResourceLimits();

    /**
     * @return the userData
     */
    public UserData UserData();

    /**
     * @return the ownership
     */
    public Ownership Ownership();

    /**
     * @return the timeBasedFilter
     */
    public TimeBasedFilter TimeBasedFilter();

    /**
     * @return the readerDataLifecycle
     */
    public ReaderDataLifecycle ReaderDataLifecycle();

    /**
     * @return the Representation
     */
    public DataRepresentation Representation();

    /**
     * @return the typeConsistency
     */
    public TypeConsistencyEnforcement TypeConsistency();

    /**
     * @return the durabilityService
     */
    public DurabilityService DurabilityService();

    /**
     * @return the reliability
     */
    public Reliability Reliability();

    /**
     * @return the transportPriority
     */
    public TransportPriority TransportPriority();

    /**
     * @return the lifespan
     */
    public Lifespan Lifespan();

    /**
     * @return the ownershipStrength
     */
    public OwnershipStrength OwnershipStrength();

    /**
     * @return the writerDataLifecycle
     */
    public WriterDataLifecycle WriterDataLifecycle();

    /**
     * @return the partition
     */
    public Partition getPartition();

    /**
     * @return the groupData
     */
    public GroupData getGroupData();

    /**
     * @return the entityFactory
     */
    public EntityFactory getEntityFactory();
}

