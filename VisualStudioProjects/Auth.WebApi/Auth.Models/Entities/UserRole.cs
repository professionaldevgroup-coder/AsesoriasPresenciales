using System;
using System.Collections.Generic;

namespace Auth.Models.Entities;

public partial class UserRole
{
    public string Email { get; set; } = null!;

    public int IdRole { get; set; }

    public int Id { get; set; }

    public virtual User EmailNavigation { get; set; } = null!;

    public virtual Role IdRoleNavigation { get; set; } = null!;
}
