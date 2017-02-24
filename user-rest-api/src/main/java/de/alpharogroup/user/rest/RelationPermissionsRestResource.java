package de.alpharogroup.user.rest;

import java.util.List;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.domain.Permission;
import de.alpharogroup.user.domain.RelationPermission;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.service.api.RelationPermissionService;
import de.alpharogroup.user.rest.api.RelationPermissionsResource;

public class RelationPermissionsRestResource
	extends
		AbstractRestfulResource<Integer, RelationPermission, RelationPermissionService>
	implements
	RelationPermissionsResource
{

	@Override
	public RelationPermission findRelationPermissions(final KeyValuePair<User, User> providerToSubscriber) {
		return getDomainService().findRelationPermissions(providerToSubscriber.getKey(), providerToSubscriber.getValue());
	}

	@Override
	public RelationPermission findRelationPermissions(final Triple<User, User, Permission> providerToSubscriberOfPerms) {
		return getDomainService().findRelationPermissions(
				providerToSubscriberOfPerms.getLeft(),
				providerToSubscriberOfPerms.getMiddle(),
				providerToSubscriberOfPerms.getRight());
	}

	@Override
	public List<RelationPermission> find(final KeyValuePair<User, User> providerToSubscriber) {
		return getDomainService().find(providerToSubscriber.getKey(), providerToSubscriber.getValue());
	}

	@Override
	public List<RelationPermission> find(final Triple<User, User, Permission> providerToSubscriberOfPerms) {
		return getDomainService().find(
				providerToSubscriberOfPerms.getLeft(),
				providerToSubscriberOfPerms.getMiddle(),
				providerToSubscriberOfPerms.getRight());
	}

	@Override
	public void addPermission(final Triple<User, User, Permission> providerToSubscriberOfPerms) {
		getDomainService().addPermission(
				providerToSubscriberOfPerms.getLeft(),
				providerToSubscriberOfPerms.getMiddle(),
				providerToSubscriberOfPerms.getRight());
	}

	@Override
	public void removePermission(final Triple<User, User, Permission> providerToSubscriberOfPerms) {
		getDomainService().removePermission(
				providerToSubscriberOfPerms.getLeft(),
				providerToSubscriberOfPerms.getMiddle(),
				providerToSubscriberOfPerms.getRight());
	}

	@Override
	public void removeAllPermissions(final KeyValuePair<User, User> providerToSubscriber) {
		getDomainService().removeAllPermissions(providerToSubscriber.getKey(), providerToSubscriber.getValue());
	}

}
