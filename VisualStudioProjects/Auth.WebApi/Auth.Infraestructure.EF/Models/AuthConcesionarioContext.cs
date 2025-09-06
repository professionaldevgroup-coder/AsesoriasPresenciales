using System;
using System.Collections.Generic;
using Auth.Models.Entities;
using Microsoft.EntityFrameworkCore;

namespace Auth.Infraestructure.EF.Models;

public partial class AuthConcesionarioContext : DbContext
{
    public AuthConcesionarioContext()
    {
    }

    public AuthConcesionarioContext(DbContextOptions<AuthConcesionarioContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Permission> Permissions { get; set; }

    public virtual DbSet<PermissionRole> PermissionRoles { get; set; }

    public virtual DbSet<Role> Roles { get; set; }

    public virtual DbSet<User> Users { get; set; }

    public virtual DbSet<UserRole> UserRoles { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlServer("Server=localhost;Database=AuthConcesionario;User Id=sa;Password=admin;Trusted_Connection=True;TrustServerCertificate=True;");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Permission>(entity =>
        {
            entity.Property(e => e.Description)
                .HasMaxLength(500)
                .IsUnicode(false);
        });

        modelBuilder.Entity<PermissionRole>(entity =>
        {
            entity.HasOne(d => d.IdPermissionNavigation).WithMany(p => p.PermissionRoles)
                .HasForeignKey(d => d.IdPermission)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_PermissionRoles_Permissions");

            entity.HasOne(d => d.IdRoleNavigation).WithMany(p => p.PermissionRoles)
                .HasForeignKey(d => d.IdRole)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_PermissionRoles_Roles");
        });

        modelBuilder.Entity<Role>(entity =>
        {
            entity.Property(e => e.Description)
                .HasMaxLength(500)
                .IsUnicode(false);
            entity.Property(e => e.Name)
                .HasMaxLength(50)
                .IsUnicode(false);
        });

        modelBuilder.Entity<User>(entity =>
        {
            entity.HasKey(e => e.Email);

            entity.Property(e => e.Email)
                .HasMaxLength(150)
                .IsUnicode(false);
            entity.Property(e => e.FullName)
                .HasMaxLength(150)
                .IsUnicode(false);
            entity.Property(e => e.Password)
                .HasMaxLength(150)
                .IsUnicode(false);
        });

        modelBuilder.Entity<UserRole>(entity =>
        {
            entity.Property(e => e.Email)
                .HasMaxLength(150)
                .IsUnicode(false);

            entity.HasOne(d => d.EmailNavigation).WithMany(p => p.UserRoles)
                .HasForeignKey(d => d.Email)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_UserRoles_Users");

            entity.HasOne(d => d.IdRoleNavigation).WithMany(p => p.UserRoles)
                .HasForeignKey(d => d.IdRole)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_UserRoles_Roles");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
