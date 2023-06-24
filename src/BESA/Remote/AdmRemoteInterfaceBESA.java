/*
 * @(#)AdmRemoteInterfaceBESA.java 2.0	11/01/11
 *
 * Copyright 2011, Pontificia Universidad Javeriana, All rights reserved.
 * Takina and SIDRe PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package BESA.Remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import BESA.Kernel.Agent.StateBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.Kernel.Agent.Event.EventBESA;

/**
 * This class provides the interface that allows the handling of RPC.
 *
 * @author  SIDRe - Pontificia Universidad Javeriana
 * @author  Takina  - Pontificia Universidad Javeriana
 * @version 2.0, 11/01/11
 * @since   JDK1.0
 */
public interface AdmRemoteInterfaceBESA extends Remote {

    /**
     * Makes the registry of an remote BESA administrator.
     *
     * @param admAlias Alias/name of the admnistrador.
     * @param ipAddress The IP address of the machine that contains the
     * administrator to be registered.
     * @param rmiPort The port of the machine that contains the administrator
     * to be registered.
     * @throws java.rmi.RemoteException Is generated by a number of
     * communication-related exceptions that may occur during the execution of
     * the remote method call.
     */
    public void registerRemoteAdm(String admId, String admAlias, String ipAddress, int rmiPort) throws RemoteException;

    /**
     * Makes the remote registry of an agent in a BESA container.<BR><BR>
     *
     * Creates the aid card.<BR><BR>
     *
     * Does the agent lookup.
     *
     * @param password Password of the local administrator.
     * @param administratorName Name of the administrator.
     * @param aid Is a chain formed of the following way: IP + "." + port + "." + aid.
     * @return true if the registry can be made; false otherwise.<BR><BR>
     *
     * The registry of the agent can fail if the name of the administrator is
     * not registered in the administrators table or if appears problems when
     * doing the lookup (IP of the remote admnistrador, port of the remote
     * administrator, aid).
     * @throws java.rmi.RemoteException Is generated by a number of
     * communication-related exceptions that may occur during the execution of
     * the remote method call.
     */
    public boolean registerRemoteAgent(String password, String administratorName, String aid) throws RemoteException;

    /**
     * Eliminates the remote registry of an agent. To do this a null value is
     * asigned to the aid card.
     *
     * @param administratorName Name assigned to the administrator.
     * @param aid The identifier of the agent.
     * @param password Password of the local administrator.
     * @throws java.rmi.RemoteException Is generated by a number of
     * communication-related exceptions that may occur during the execution of
     * the remote method call.
     */
    public void unregisterRemoteAgent(String password, String administratorName, String aid) throws RemoteException;

    /**
     * Creates a remote service in a BESA container.
     *
     * @param servName The oficial name of the service to be published.
     * @param descriptors A group of alias that describes the service.
     * @param password Password of the local administrator.
     * @throws java.rmi.RemoteException Is generated by a number of
     * communication-related exceptions that may occur during the execution of
     * the remote method call.
     */
    public void createRemoteService(String password, String servName, ArrayList descriptors) throws RemoteException;

    /**
     * Binds a remote service associated to an agent.
     *
     * @param aid The identifier of the agent.
     * @param servName The oficial name of the service.
     * @param password Password of the local administrator.
     * @return
     * @throws java.rmi.RemoteException Is generated by a number of
     * communication-related exceptions that may occur during the execution of
     * the remote method call.
     */
    public boolean bindRemoteService(String password, String aid, String servName) throws RemoteException;

    /**
     * Makes the remote registry of an agent in a BESA container.<BR><BR>
     *
     * Creates the aid card.<BR><BR>
     *
     * Does the agent lookup.
     *
     * @param agAlias Name of the agent with whom it will be identified in the
     * BESA container.
     * @param agId The identifier of the agent.
     * @param admId The identifier of the BESA container.
     * @throws java.rmi.RemoteException Is generated by a number of
     * communication-related exceptions that may occur during the execution of
     * the remote method call.
     */
    public void registerRemoteAgents(String agAlias, String agId, String admId) throws RemoteException;

    /**
     * Sends an event to an agent.
     *
     * @param ev The event BESA to be sending.
     * @param aid The identifier of the agent.
     * @throws BESA.Exception.ExceptionBESA_SendMessageError
     * @throws java.rmi.RemoteException Is generated by a number of
     * communication-related exceptions that may occur during the execution of
     * the remote method call.
     */
    public void sendEvent(EventBESA ev, String aid) throws RemoteException;

    /**
     * Updates the directories of identifiers and alias of agents in a remote
     * BESA container.
     *
     * @param admAlias Alias/name of the admnistrador.
     * @param agIdList List of agents identifiers.
     * @param agAliasList List of agents names.
     * @throws java.rmi.RemoteException Is generated by a number of
     * communication-related exceptions that may occur during the execution of
     * the remote method call.
     */
    public void updateRemoteAgentDirectory(String admAlias, ArrayList agIdList, ArrayList agAliasList) throws RemoteException;

    /**
     * Synchronizes the infomaci�n of agents in the BESA containers assets.
     *
     * @param admId The identifier of the BESA container.
     * @param agIdList List of agents identifiers.
     * @param aliasList List of agents names.
     * @throws java.rmi.RemoteException Is generated by a number of
     * communication-related exceptions that may occur during the execution of
     * the remote method call.
     */
    public void synchronizeRemoteAgentDirectory(String admId, ArrayList agIdList, ArrayList aliasList) throws RemoteException;

    /**
     * Moves an external agent to the associated local container.
     *
     * @param aliasAg Name of the agent with whom it will be identified in the
     * BESA container.
     * @param stateAg The agent associated state object.
     * @param structAg The agent associated structure.
     * @param passwdAg Agent password.
     * @param nameClassAgent A String that represents the agent associated class.
     * @throws java.rmi.RemoteException
     */
    public void moveAgentReceive(String aliasAg, StateBESA stateAg, StructBESA structAg, double passwdAg, String nameClassAgent) throws RemoteException;

    /**
     * Moves a local agent to an external BESA container.
     *
     * @param agId The identifier of the agent.
     * @param aliasDestinationAdm Alias/name of the destination admnistrador.
     * @param passwdAg Agent password.
     * @throws java.rmi.RemoteException Is generated by a number of
     * communication-related exceptions that may occur during the execution of
     * the remote method call.
     */
    public void moveAgentSend(String agId, String aliasDestinationAdm, double passwdAg) throws RemoteException;
    
    public void killRemoteAgent(String agId, double agentPassword) throws RemoteException;
}
