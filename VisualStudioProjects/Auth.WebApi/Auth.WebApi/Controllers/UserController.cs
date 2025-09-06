using Auth.Infraestructure.EF.Models;
using Auth.WebApi.Services.User;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace Auth.WebApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly AuthConcesionarioContext _authConcesionarioContext;
        public UserController() {
            _authConcesionarioContext = new AuthConcesionarioContext();
        }

        [HttpGet]
        [Route("GetUserProfile")]
        public IActionResult GetUserProfile(string email) {

            var user = _authConcesionarioContext
                        .Users.Where(u => u.Email.Equals(email.Trim()))
                        .Include(u=> u.UserRoles)
                        .FirstOrDefault();

            var userReturn = UserMapper.MapToUserDto(user, _authConcesionarioContext);

            if (userReturn == null) {
                return StatusCode(StatusCodes.Status500InternalServerError,
                    new { mensaje = "The user not exist on the database" });
            }
            return Ok(userReturn);
        }

    
    }
}
