package com.java.nile;

import com.java.nile.repository.AdminRepository;
import com.java.nile.services.AdminService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceApplicationTests {

    @Autowired
    private AdminService adminService;

    @MockBean
    private AdminRepository adminRepository;

//	@Test
//	public void getAllAdminsTest(){
//		UUID id=UUID.fromString("fff2f54e-357a-4fc4-bfb5-a8f2ff0d67e6");
//		when(adminRepository.findAll()).
//				thenReturn(Stream.of(new Admin(id,"Nimrah Yousuf","Nimrah97","Nimrah","House 400, Street 500, Sector Q-8/4, Islamabad, Pakistan","0456778987","nimrah@gmail.com","Pakistan",20000.00, true)).collect(Collectors.toList()));
//		assertEquals(1,adminService.getAllAdmins().size());
//	}

//    @Test
//    public void getAdminTest() {
//        UUID id = UUID.fromString("fff2f54e-357a-4fc4-bfb5-a8f2ff0d67e6");
//        when(adminRepository.findById(id)).thenReturn(Optional.of(new Admin(id, "Arslan Ahmed", "ar", "12334", "Flat 56, Block 23, DHA phase 2", "03124333", "arslan@gmail.com", "Canada", 2300.99, true)));
//        assertEquals("Arslan Ahmed", adminService.getAdmin(id).get().getName());
//        assertEquals("Flat 56, Block 23, DHA phase 2", adminService.getAdmin(id).get().getAddress());
//        assertEquals("03124333", adminService.getAdmin(id).get().getContactInformation());
//        assertEquals("arslan@gmail.com", adminService.getAdmin(id).get().getEmail());
//        assertEquals("Canada", adminService.getAdmin(id).get().getCountry());
//        assertEquals(2300.99, adminService.getAdmin(id).get().getBalance());
//    }

//    @Test
//    public void addAdminTest() {
//        UUID id = UUID.fromString("fff2f54e-357a-4fc4-bfb5-a8f2ff0d67e6");
//        Admin admin = new Admin(id, "Asad Raza", "Asad97", "12234", "House 45, Street 54, Berlin, Germany", "033323453", "asad_raza@yahoo.com", "Germany", 9000.00, true);
//
//        adminService.addAdmin(admin);
//
//        //assertNotNull(admin);
//        verify(adminRepository, times(1)).save(admin);
//    }

//    @Test
//    public void updateAdminTest() {
//        UUID id = UUID.fromString("92581bbb-77a2-4d16-b1d8-35f0630d5cce");
//
//        UUID updatedId = UUID.fromString("fff2f54e-357a-4fc4-bfb5-a8f2ff0d67e6");
//
//        Admin admin = new Admin(id, "Zeela Bukhari", "nim", "Zeela", "Block 5-D, Las Vegas, USA", "067553453", "zeela@yahoo.com", "USA", 8970.00, true);
//        Admin updatedAdmin = new Admin(updatedId, "shazma yousuf", "Shazma", "shaz", "flat 65, block 444A, California, USA", "099976", "Shazma@gmail.com", "USA", 78000.00, true);
//        when(adminRepository.findById(id)).thenReturn(Optional.of(updatedAdmin));
//
//        adminRepository.save(updatedAdmin);
//
//        verify(adminRepository, times(1)).save(updatedAdmin);
//    }

//    @Test
//    public void deleteAdminTest() {
//        UUID id = UUID.fromString("92581bbb-77a2-4d16-b1d8-35f0630d5cce");
//        adminService.deleteAdmin(id);
//        verify(adminRepository, times(1)).deleteById(id);
//    }
}

