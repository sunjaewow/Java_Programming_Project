package main;

import commend.*;
import dao.MovieDAO;
import domain.Member;
import facade.ReservationFacade;
import service.announcement.AnnouncementService;
import service.announcement.AnnouncementServiceImp;
import service.announcement.AnnouncementServiceProxy;
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

    private final MovieDAO movieDAO;

    private final AnnouncementService announcementService;

    private final Map<Integer, Command> commandMap = new HashMap<>();

    private final Map<Integer, Command> movieManageCommandMap = new HashMap<>();



    public MainMenu(Member member) {
        this.sc = new Scanner(System.in);
        this.member = member;
        this.movieDAO= new MovieDAO();
        this.movieService = new MovieServiceProxy(new MovieServiceImp(movieDAO));;
        this.reservationService = new ReservationServiceImp();
        this.reservationFacade = new ReservationFacade();
        this.announcementService = new AnnouncementServiceProxy(new AnnouncementServiceImp());


        // 커맨드 등록
        commandMap.put(1, new ReserveCommand(reservationFacade, member));
        commandMap.put(3, new MyPageCommand(reservationService, member));
        commandMap.put(4, new AnnouncementCommand(announcementService, member));
        commandMap.put(5, new ExitCommand());

        // 영화관리 하위 메뉴 커맨드 등록
        movieManageCommandMap.put(1, new CreateMovieCommand(movieService, member));
        movieManageCommandMap.put(2, new DeleteMovieCommand(movieService, member));
        movieManageCommandMap.put(3, () -> {}); // 뒤로가기(아무 동작 안함)

    }

    public void showMenu() {
        while (true) {
            PrintUtil.printMainMenu();
            int choice = InputUtil.getIntInput(sc);
            if (choice == 2) { // 영화관리 서브메뉴로 진입
                showMovieManageMenu();
                continue;
            }

            Command cmd = commandMap.get(choice);
            if (cmd != null) {
                cmd.execute();
                if (choice==5)
                {
                    break;
                }
            } else {
                System.out.println("번호를 다시 입력해주세요.");
            }
        }
    }
    private void showMovieManageMenu() {
        while (true) {
            PrintUtil.printMovieManager();
            int choice = InputUtil.getIntInput(sc);

            Command cmd = movieManageCommandMap.get(choice);
            if (cmd != null) {
                if (choice == 3) break; // 3번은 뒤로가기
                cmd.execute();
            } else {
                System.out.println("번호를 다시 입력해주세요.");
            }
        }
    }

}
