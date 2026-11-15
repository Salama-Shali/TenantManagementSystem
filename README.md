# Tenant Management System
An Android app for landlords to record tenants, see total rent, and call tenants.
## Download
Latest APK: see **Releases** on the right of this page.
## Features
- Register and log in
- Dashboard with number of tenants and total rent
- Add tenants and view all tenants (saved with Room)
- Call a tenant, options menu and navigation drawer
## Architecture
ui/ Activities, Fragments and TenantViewModel (UI layer)
data/ Tenant, TenantDao, TenantDatabase, TenantRepository (data layer)
Screens → TenantViewModel (LiveData) → TenantRepository → Room
## Team
| Stage | Member | Admission No. | Pull request |
|---|---|---|---|
| 1 Lead | Roselyne Salama Shali Mwalagho | 192789 | Direct push (no PR) |
| 2 ViewModel | Juliet Nyakiamo | 200159 | [PR #1](https://github.com/Salama-Shali/TenantManagementSystem/pull/1) |
| 3 Room | Kimberly Amani | 175852 | [PR #2](https://github.com/Salama-Shali/TenantManagementSystem/pull/2) |
| 4 Screens | Juliet Nyakiamo | 200159 | [PR #3](https://github.com/Salama-Shali/TenantManagementSystem/pull/3) |
| 5 Data integration | Elizabeth Gitacu | 189600 | [PR #4](https://github.com/Salama-Shali/TenantManagementSystem/pull/4) |
| 6 Release | Roselyne Salama Shali Mwalagho | 192789 | Pending |