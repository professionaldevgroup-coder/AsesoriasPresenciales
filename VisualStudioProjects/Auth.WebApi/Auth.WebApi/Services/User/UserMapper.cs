using Auth.Infraestructure.EF.Models;
using Auth.Models.Dtos;
using Microsoft.EntityFrameworkCore;
using System.Linq;

namespace Auth.WebApi.Services.User
{
    public class UserMapper
    {
        public static UserDto MapToUserDto(Auth.Models.Entities.User user, AuthConcesionarioContext authConcesionarioContext) {

            var role = authConcesionarioContext.Roles
                        .Include(r => r.PermissionRoles)
                        .FirstOrDefault(r=>r.Id == user.UserRoles.FirstOrDefault().IdRole);
            
            var roleDto = new RoleDto() { 
                Name = role.Name,
                Permissions = new List<string>()
            };

            foreach (var rolePermission in role.PermissionRoles) {
                var permission = authConcesionarioContext
                                    .Permissions.FirstOrDefault(p => p.Id == rolePermission.IdPermission);
                roleDto.Permissions.Add(permission.Description);
            }

            var userDto = new UserDto()
            {
                BirthDay = user.BirthDay,
                Email = user.Email,
                FullName = user.FullName,
                Role = roleDto

            };

            return userDto;
        }
    }
}
