<%!
    boolean isLoggedIn(HttpServletRequest req, HttpServletResponse res) {
        boolean status = false;

        String user = (String) req.getAttribute("user");
        if (user == null || user.equals("")) {
            status = false;
        } else {
            status = true;
        }
        return status;
    }
%>