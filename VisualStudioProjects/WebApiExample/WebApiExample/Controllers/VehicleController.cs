using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace WebApiExample.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class VehicleController : ControllerBase
    {
        [HttpPost]
        [Route("CreateVehicule")]
        public IActionResult CreateVehicule(string brand,
            int doorAmout,
            int amountPassagers,
            int year,
            string model,
            string color)
        {

            return StatusCode(500,new { message = "ServerError" });

        }
    }
}
