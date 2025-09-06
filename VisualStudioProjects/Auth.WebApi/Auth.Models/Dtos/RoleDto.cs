using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Auth.Models.Dtos
{
    public class RoleDto
    {
        public string Name { get; set; } = null!;
        public List<string> Permissions { get; set; }
    }
}
