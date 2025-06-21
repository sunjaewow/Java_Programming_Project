package main;

import commend.*;
import dao.MovieDAO;
import domain.Member;
import facade.ReservationFacade;
import service.movie.MovieService;
import service.movie.MovieServiceImp;
import service.movie.MovieServiceProxy;
import service.reservation.ReservationService;
import service.reservation.ReservationServiceImp;
import util.InputUtil;
import util.PrintUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
    private final Scanner sc;
    private final Member member;

    private final MovieService movieService;

    private final ReservationService reservationService;

    private final ReservationFacade reservationFacade;

    private final Map<Integer, Command> commandMap = new HashMap<>();


    public MainMenu(Scanner sc, Member member) {
        this.sc = sc;
        this.member = member;
        MovieDAO movieDAO = new MovieDAO();
        MovieService movieServiceImp = new MovieServiceImp(movieDAO);
        this.movieService = new MovieServiceProxy(movieServiceImp);;
        this.reservationService = new ReservationServiceImp();
        this.reservationFacade = new ReservationFacade();

        // 커맨드 등록
        commandMap.put(1, new ReserveCommand(reservationFacade, member));
        commandMap.put(2, new RegisterMovieCommand(movieService, member));
        commandMap.put(3, new MyPageCommand(reservationService, member));
        commandMap.put(4, new ExitCommand());
    }

    public void showMenu() {
        while (true) {
            PrintUtil.printMainMenu();
            int choice = InputUtil.getIntInput(sc);

            Command cmd = commandMap.get(choice);
            if (cmd != null) {
                cmd.execute();
                if (choice==4)
                {
                    break;
                }
            } else {
                System.out.println("번호를 다시 입력해주세요.");
            }
        }
    }
}
