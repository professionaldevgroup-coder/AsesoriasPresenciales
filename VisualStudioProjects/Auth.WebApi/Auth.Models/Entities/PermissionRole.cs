using System;
using System.Collections.Generic;

namespace Auth.Models.Entities;

public partial class PermissionRole
{
    public int IdRole { get; set; }

    public int IdPermission { get; set; }

    public int Id { get; set; }

    public virtual Permission IdPermissionNavigation { get; set; } = null!;

    public virtual Role IdRoleNavigation { get; set; } = null!;
}
