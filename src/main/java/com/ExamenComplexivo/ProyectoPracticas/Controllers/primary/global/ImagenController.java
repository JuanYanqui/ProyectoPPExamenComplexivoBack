package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/imagen")
public class ImagenController {

    private static String UPLOAD_DIR = "uploads";
    public static final long MAX_IMAGE_SIZE = 1024000; // 1000 KB en bytes

    @PostMapping("/crear")
    public void uploadImage(@RequestParam("image") MultipartFile image) throws IOException {
        if (image.getSize() > MAX_IMAGE_SIZE) {
            throw new RuntimeException("La imagen es demasiado grande. El tamaño máximo permitido es de " + MAX_IMAGE_SIZE + " bytes.");
        }
        byte[] bytes = image.getBytes();
        Path path = Paths.get(UPLOAD_DIR + "/" + image.getOriginalFilename());
        Files.write(path, bytes);
    }

    @GetMapping("/images/{nombreimg}")
    public byte[] getImagen(@PathVariable String imageName) throws IOException {
        Path path = Paths.get(UPLOAD_DIR + "/" + imageName);
        return Files.readAllBytes(path);
    }

}