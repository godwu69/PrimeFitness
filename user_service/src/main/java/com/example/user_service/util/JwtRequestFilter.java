//package com.example.user_service.filter;
//
//import com.example.user_service.service.UserService; // Nhập dịch vụ người dùng
//import com.example.user_service.util.JwtUtil; // Nhập lớp JwtUtil
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws ServletException, IOException {
//
//        final String authorizationHeader = request.getHeader("Authorization");
//
//        String username = null;
//        String jwt = null;
//
//        // Kiểm tra nếu JWT tồn tại và bắt đầu bằng "Bearer "
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            jwt = authorizationHeader.substring(7); // Lấy JWT từ header
//            username = jwtUtil.extractUsername(jwt); // Trích xuất username từ JWT
//        }
//
//        // Kiểm tra nếu username chưa được xác thực
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username); // Tìm người dùng
//            if (jwtUtil.validateToken(jwt, userDetails)) { // Kiểm tra tính hợp lệ của JWT
//                // Tạo đối tượng xác thực và đặt vào SecurityContext
//                UsernamePasswordAuthenticationToken authentication =
//                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authentication); // Đặt xác thực vào SecurityContext
//            }
//        }
//        chain.doFilter(request, response); // Tiếp tục chuỗi filter
//    }
//}
