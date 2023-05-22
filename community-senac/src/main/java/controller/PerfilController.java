package controller;

import model.DAO.UserDAO;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.fileupload.servlet.ServletFileUpload.isMultipartContent;

@WebServlet( urlPatterns = {"/perfil"})

public class PerfilController extends HttpServlet {
    public UserDAO repository = new UserDAO();
    public UserService userService = new UserService(repository);
    private final User user = new User();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.sendRedirect("/perfil.jsp");

        System.out.println(user.getEmail() + "email do usuario ao entrar no perfil");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String> parameters = uploadImage(req);

        String ImagePath = parameters.get("image");

        user.setDataNascimento(parameters.get("dataNascimento"));
        user.setCurso(parameters.get("curso"));
        user.setSexo(parameters.get("sexo"));
        user.setBio(parameters.get("bio"));
        user.setCelular(parameters.get("celular"));
        //user.setEmail(parameters.get("email"));
       // user.setNome(parameters.get("nome"));
        user.setEmail("deive@senacsp.edu.br");
        user.setNome("Deive");
        user.setImage(ImagePath);


        boolean atualizado = userService.atulizandoUsuario(user);

        if (!atualizado) {
            System.out.println("****Erro****");
        } else {
            System.out.println("Atualizado!!!!");
            resp.sendRedirect("/home");
            System.out.println(user.getImage());
        }
    }
    private Map<String, String> uploadImage(HttpServletRequest httpServletRequest) {

        Map<String, String> requestParameters = new HashMap<>();

        if (isMultipartContent(httpServletRequest)) {

            try {

                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

                List<FileItem> fileItems = new ServletFileUpload(diskFileItemFactory).parseRequest(httpServletRequest);

                for (FileItem fileItem : fileItems) {

                    checkFieldType(fileItem, requestParameters);

                }

            } catch (Exception ex) {

                requestParameters.put("image", "img/default-car.jpg");

            }

        }

        return requestParameters;

    }

    private void checkFieldType(FileItem item, Map requestParameters) throws Exception {

        if (item.isFormField()) {

            requestParameters.put(item.getFieldName(), item.getString());

        } else {

            String fileName = processUploadedFile(item);
            requestParameters.put("image", "img/".concat(fileName));

        }

    }

    private String processUploadedFile(FileItem fileItem) throws Exception {
        Long currentTime = new Date().getTime();
        String fileName = currentTime.toString().concat("-").concat(fileItem.getName().replace(" ", ""));
        String filePath = this.getServletContext().getRealPath("img").concat(File.separator).concat(fileName);
        fileItem.write(new File(filePath));
        return fileName;
    }
}
