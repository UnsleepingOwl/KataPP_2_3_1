package kata.web.controller;

import kata.web.dao.UserDao;
import kata.web.dao.UserDaoImp;
import kata.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserDao userDao = new UserDaoImp();

    //  Получение всех User из DAO и передача на отображение в представление Model
    @GetMapping()
    public String getUsersList(Model model) {
        model.addAttribute("users_list", userDao.listUsers());
        return "/users/all";
    }

    //  Получение User по ID из DAO и передача на отображение в представление Model
    @GetMapping("/id={id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userDao.getUserById(id));
        return "users/id";
    }

    @GetMapping("/new")
    public String newUserForm(@ModelAttribute("newUser") User user) {
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        userDao.add(user);
        return "redirect:/users";
    }

    @GetMapping("/id={id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("editedUser", userDao.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/id={id}")
    public String updateUser(@ModelAttribute("editedUser") @Valid User user, BindingResult bindingResult, @PathVariable("id") long id) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        userDao.update(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/id={id}")
    public String deleteUser(@PathVariable("id") long id) {
        userDao.delete(id);
        return "redirect:/users";
    }
}
