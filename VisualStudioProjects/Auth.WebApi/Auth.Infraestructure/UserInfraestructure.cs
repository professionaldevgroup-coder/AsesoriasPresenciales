using Auth.Models.Entities;
using System.Data;
using System.Data.SqlClient;

namespace Auth.Infraestructure
{
    public class UserInfraestructure
    {
        private string connectionString =
            "Server=localhost;Database=AuthConcesionario;User Id=sa;Password=admin;";

        public UserInfraestructure()
        {
        }

        public User GetUserProfile(string email)
        {
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                using (SqlCommand command = new SqlCommand("usp_getUser", connection))
                {
                    User user = null;
                    command.CommandType = CommandType.StoredProcedure;
                    command.Parameters.Add("@email", SqlDbType.VarChar, 150).Value = email;
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            user = new User();
                            user.Email = reader.GetString("Email");
                            user.FullName = reader.GetString("FullName");
                            user.Password = reader.GetString("Password");
                            user.BirthDay = reader.GetDateTime("BirthDay");

                            Rol rol = new Rol();
                            rol.Name = reader.GetString("Name");
                            rol.Id = reader.GetInt32("Id");
                            rol.Description = reader.GetString("Description");

                            user.Rol = rol;
                        }

                        return user;
                    }
                }
            }
        }
    }
}
