using System;
using System.Collections.Generic;

namespace Auth.Models.Entities;

public partial class Permission
{
    public int Id { get; set; }

    public string Description { get; set; } = null!;

    public virtual ICollection<PermissionRole> PermissionRoles { get; set; } = new List<PermissionRole>();
}
