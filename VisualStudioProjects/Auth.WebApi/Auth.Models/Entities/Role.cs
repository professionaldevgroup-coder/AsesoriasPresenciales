using System;
using System.Collections.Generic;

namespace Auth.Models.Entities;

public partial class Role
{
    public int Id { get; set; }

    public string Name { get; set; } = null!;

    public string? Description { get; set; }

    public virtual ICollection<PermissionRole> PermissionRoles { get; set; } = new List<PermissionRole>();

    public virtual ICollection<UserRole> UserRoles { get; set; } = new List<UserRole>();
}
