using System;
using System.Collections.Generic;

namespace Auth.Models.Entities;

public partial class User
{
    public string Email { get; set; } = null!;

    public string Password { get; set; } = null!;

    public string FullName { get; set; } = null!;

    public DateOnly BirthDay { get; set; }

    public virtual ICollection<UserRole> UserRoles { get; set; } = new List<UserRole>();
}
