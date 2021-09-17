import axios from "axios";

export const BASE_URL = "http://localhost:8080";

export const postUrl = BASE_URL + "/api/posts";
export const adminUrl = BASE_URL + "/admin/home";
export const loggedInUser = BASE_URL + "/api/users/loggedInUser";

export const HTTPClient = axios.create({
  baseURL: BASE_URL,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
    auth: localStorage.getItem("auth") || "",
  },
  withCredentials: true,
});

// HTTPClient.interceptors.response.use(
//   (response) => {
//     return response;
//   },
//   (error) => {
//     if (error.response) {
//       if (error.response.status === 401 || error.response.status === 403) {
//         localStorage.removeItem("auth");
//         window.location.href = "/";
//       }
//     } else {
//       return Promise.reject(error);
//     }
//   }
// );
